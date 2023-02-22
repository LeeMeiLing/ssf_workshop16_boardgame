package sg.edu.nus.iss.ssf_workshop16_boardgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.ssf_workshop16_boardgame.models.BoardGame;
import sg.edu.nus.iss.ssf_workshop16_boardgame.repositories.BoardGameRepo;

@RestController
@RequestMapping(path="/api/boardgame")
public class BoardGameController {
    
    @Autowired
    private BoardGameRepo bgRepo;

    @PostMapping
    public ResponseEntity<BoardGame> save(@RequestBody BoardGame bg){

        BoardGame boardGame = bgRepo.save(bg);

        return new ResponseEntity<BoardGame>(boardGame , HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<BoardGame> findBoardGameById(@PathVariable Integer id){

        BoardGame boardGame = bgRepo.findBoardGameById(id);

        return new ResponseEntity<BoardGame>(boardGame, HttpStatus.OK);
    }

}
