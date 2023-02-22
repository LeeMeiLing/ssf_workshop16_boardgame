package sg.edu.nus.iss.ssf_workshop16_boardgame.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("payload")
public class Payload implements Serializable{
    
    @Id
    private Integer id;

    private String itemName;

    

}
