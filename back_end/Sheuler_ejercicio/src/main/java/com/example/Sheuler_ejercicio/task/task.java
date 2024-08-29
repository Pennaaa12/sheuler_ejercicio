package com.example.Sheuler_ejercicio.task;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.Sheuler_ejercicio.models.usuario;
import com.example.Sheuler_ejercicio.service.emailService;
import com.example.Sheuler_ejercicio.service.usuarioService;

@Component
public class task {

	@Autowired
    private usuarioService data;

    @Autowired
    private emailService email;

    @Scheduled(fixedRate =1000)
    public void sendNotificationcron() {
        var listaUsuario=data.cambiarTipoDocumento();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario que requiere actualizar documento: "+ 
            usuario.getNombre_completo());
            email.cambiarTipoDocumento(usuario.getCorreo_electronico(),usuario.getNombre_completo(),usuario.getTipo_documento(),usuario.getNumero_documento(),usuario.getCorreo_electronico(),usuario.getContrasena());
        }
    }
}
