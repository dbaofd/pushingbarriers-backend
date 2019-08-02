package org.pushingbarriers.bgsystem.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.pushingbarriers.bgsystem.annotation.AuthToken;
import org.pushingbarriers.bgsystem.util.ConstantKit;
import org.pushingbarriers.bgsystem.util.RedisHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class AuthorizationInterceptor implements HandlerInterceptor {
    //header of authorization
    private String httpHeaderName = "Authorization";

    //default value is 401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    //if it is failed to authorize, then return ErrorCode
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    /**
     * Request Key used for storing login user model
     */
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        RedisHelper redisHelper=new RedisHelper();

        // if the method has @AuthToken annotation, we need to check it token.
        if (method.getAnnotation(AuthToken.class) != null || handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null) {
            //String token = request.getHeader(httpHeaderName);
            String token = request.getHeader("token");
            //log.info("Get token from request is {} ", token);
            String adminname = "";
            Jedis jedis = redisHelper.initializeJedis();
            if (token != null && token.length() != 0) {
                adminname = jedis.get(token);
                //log.info("Get adminname from Redis is {}", adminname);
            }
            if (adminname != null && !adminname.trim().equals("")) {
                //log.info("token birth time is: {}",jedis.get(adminname+token));
                Long tokeBirthTime = Long.valueOf(jedis.get(token + adminname));
                //log.info("token Birth time is: {}", tokeBirthTime);
                Long diff = System.currentTimeMillis() - tokeBirthTime;
                //log.info("token is exist : {} ms", diff);
                //reset expire time
                if (diff > ConstantKit.TOKEN_RESET_TIME) {
                    jedis.expire(adminname, ConstantKit.TOKEN_EXPIRE_TIME);
                    jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
                    //log.info("Reset expire time success!");
                    Long newBirthTime = System.currentTimeMillis();
                    jedis.set(token + adminname, newBirthTime.toString());
                }

                //close redis
                redisHelper.closeJedis(jedis);
                request.setAttribute(REQUEST_CURRENT_KEY, adminname);
                return true;
            } else {
                JSONObject jsonObject = new JSONObject();

                PrintWriter out = null;
                try {
                    response.setStatus(unauthorizedErrorCode);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    jsonObject.put("code", ((HttpServletResponse) response).getStatus());
                    jsonObject.put("message", HttpStatus.UNAUTHORIZED);
                    out = response.getWriter();
                    out.println(jsonObject);

                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                }

            }

        }
        //if no AuthToken annotation found, then let it go, user can request this method without check its token
        request.setAttribute(REQUEST_CURRENT_KEY, null);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
