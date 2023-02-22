package sg.edu.nus.iss.ssf_workshop16_boardgame.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.ssf_workshop16_boardgame.models.BoardGame;

@Repository
public class BoardGameRepo {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    public BoardGame save(BoardGame boardgame){

        redisTemplate.opsForValue().set(boardgame.getId(), boardgame);
        return boardgame;

    }

    public BoardGame findBoardGameById(Integer id){

        BoardGame bg = (BoardGame) redisTemplate.opsForValue().get(id);
        return bg;

    }

}
