// package com.boardapp.boardapi.common.util;

// import java.util.List;
// import java.util.concurrent.TimeUnit;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.core.ValueOperations;
// import org.springframework.stereotype.Repository;
// import jakarta.annotation.Resource;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Repository
// @RequiredArgsConstructor
// public class RedisOperator<T> {
//     @Qualifier("redisObjectTemplate")
//     private RedisTemplate<String, T> redisTemplate;

//     @Resource(name = "redisObjectTemplate")
//     private ValueOperations<String, T> valueOperations;

//     @Resource(name = "redisObjectTemplate")
//     private ValueOperations<String, List<T>> valueOperationsWithList;

//     public T getValue(String key) {
//         try {
//             log.debug("RedisOperator get value --- key : {}", key);
//             return valueOperations.get(key);
//         } catch (Exception e) {
//             log.error("RedisOperator get value error : {}", e.getMessage());
//             return null;
//         }
//     }

//     public List<T> getListValue(String key) {
//         try {
//             log.debug("RedisOperator get list value --- key : {}", key);

//             return valueOperationsWithList.get(key);
//         } catch (Exception e) {
//             log.error("RedisOperator get list vaue error : {}", e.getMessage());

//             return null;
//         }
//     }

//     public void set(String key, T value, Long timeout, TimeUnit timeUnit) {
//         try {
//             valueOperations.set(key, value, timeout, timeUnit);

//             log.debug("RedisOperator set --- key : {}", key);
//         } catch (Exception e) {
//             log.error("RedisOperator occured error when set : {}", e.getMessage());
//         }
//     }

//     public void setList(String key, List<T> valueList, Long timeout, TimeUnit timeUnit) {
//         try {
//             valueOperationsWithList.set(key, valueList, timeout, timeUnit);

//             log.debug("RedisOperator set --- key : {}", key);
//         } catch (Exception e) {
//             log.error("RedisOperator occured error when set : {}", e.getMessage());
//         }
//     }

//     public void delete(String key) {
//         try {
//             redisTemplate.delete(key);

//             log.debug("RedisOperator delete --- key : {}", key);
//         } catch (Exception e) {
//             log.error("RedisOperator delete error : {}", e.getMessage());
//         }
//     }
// }
