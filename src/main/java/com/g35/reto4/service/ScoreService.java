package com.g35.reto4.service;





import com.g35.reto4.dbo.ScoreDbo;
import com.g35.reto4.model.ScoreModel;
import com.g35.reto4.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public List<ScoreModel> obtener() {
        return scoreRepository.findAll();

    }

    public void crear(ScoreModel score) {
        if (!scoreRepository.existsById(score.getIdScore())) {
            scoreRepository.save(score);
        }

    }

    public void eliminar(int id) {
        scoreRepository.deleteById(id);
    }


    public void actualizar(ScoreDbo scoreDbo) {
        if (scoreRepository.existsById(scoreDbo.getIdScore())) {
            ScoreModel score = scoreRepository.findById(scoreDbo.getIdScore()).get();
            score.setScore(scoreDbo.getScore());
            scoreRepository.save(score);
        }
    }
}

