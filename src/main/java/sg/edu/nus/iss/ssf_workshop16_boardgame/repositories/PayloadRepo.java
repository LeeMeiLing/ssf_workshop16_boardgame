package sg.edu.nus.iss.ssf_workshop16_boardgame.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.ssf_workshop16_boardgame.models.Payload;

@Repository
public class PayloadRepo {
    
    public static final String HASH_KEY_NAME = "PayloadItem";

    @Autowired
    private RedisTemplate redisTemplate;
    // private RedisTemplate<String, Object> redisTemplate;

    public Payload save(Payload payload){

        redisTemplate.opsForHash().put(HASH_KEY_NAME, payload.getId(), payload);
        return payload;

    }

    public List<Payload> findAll(){

        return redisTemplate.opsForHash().values(HASH_KEY_NAME);

    }

    public Payload findPayloadById(Integer id){

        return (Payload) redisTemplate.opsForHash().get(HASH_KEY_NAME, id);
    }

    public String deletePayloadById(Integer id){

        Long lResult = redisTemplate.opsForHash().delete(HASH_KEY_NAME, id);

        if (lResult >= 0){
            return "deleted";
        }else{
            return "failed";
        }
    }

}
