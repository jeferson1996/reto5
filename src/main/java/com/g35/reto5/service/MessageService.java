package com.g35.reto5.service;



import com.g35.reto5.dbo.MessageDbo;
import com.g35.reto5.model.MessageModel;
import com.g35.reto5.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<MessageModel> obtener() {
        return messageRepository.findAll();

    }

    public void crear(MessageModel message) {
        if (!messageRepository.existsById(message.getIdMessage())) {
            messageRepository.save(message);
        }

    }

    public void eliminar(int id) {
        messageRepository.deleteById(id);
    }


    public void actualizar(MessageDbo messageDbo) {
        if (messageRepository.existsById(messageDbo.getIdMessage())) {
            MessageModel message = messageRepository.findById(messageDbo.getIdMessage()).get();
            message.setMessageText(messageDbo.getMessageText());
            messageRepository.save(message);

        }
    }
}



