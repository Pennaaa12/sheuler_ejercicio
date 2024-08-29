package com.example.Sheuler_ejercicio.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public String enviarNotificacionCuenta(String destinatario, String nombre_completo, String tipo_documento, String numero_documento,String correo, String contrasena ) {

		try {
			
			String asunto="Hola " +nombre_completo + " ";
			String cuerpo=""
					+"<body style='margin: 0; padding: 0; background-color: #CCCCCC;'>" 
			      +  "  <div style='background-color: #CCCCCC;'>" 
			       + "   <div style='background-color: white; max-width: 600px; margin: auto; padding: 20px; box-sizing: border-box;'>" 
			      +  "<h1 style='color: #2B56C5; text-align: center; font-size: 24px; margin-top: 20px;'>" + nombre_completo + ", ¡bienvenid@ a Scheuler!</h1>"

			    +    "      <p style='color: #000; font-size: 16px; line-height: 1.5; margin-top: 20px;'>" 
			      +  "     Somos el sistema Scheuler, es de nuestro agrado recibirte en nuestro sistema" 
			    +    "      </p>"
			      +  "      </div>" 
			     +   "   </div>" 
			     +   "</body>";
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente";
			}else {
				return "No se pudo enviar";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}
	
	public String cambiarTipoDocumento(String destinatario, String nombre_completo, String tipo_documento, String numero_documento,String correo, String contrasena ) {

		try {
			
			String asunto="Hola " +nombre_completo + " ";
			String cuerpo=""
					+"<body style='margin: 0; padding: 0; background-color: #CCCCCC;'>" 
			      +  "  <div style='background-color: #CCCCCC;'>" 
			       + "   <div style='background-color: white; max-width: 600px; margin: auto; padding: 20px; box-sizing: border-box;'>" 
			      +  "<h1 style='color: #2B56C5; text-align: center; font-size: 24px; margin-top: 20px;'>" + nombre_completo + ", ¡Recuerda actualizar tu tipo de documento!</h1>"

			    +    "      <p style='color: #000; font-size: 16px; line-height: 1.5; margin-top: 20px;'>" 
			      +  "     Somos el sistema Scheuler" 
			    +    "      </p>" 
			   +     "      <br>" 
			   +" <strong> Tus datos son los siguientes: </strong>"
			       +"<br>"
			       +"<br>"
			       
                   + "          <strong>Nombre de Usuario: </strong> " + nombre_completo + " "
                   +"<br>"
                   + "          <strong>Tipo de documento: </strong> " + tipo_documento + " "
                   +"<br>"
                   + "          <strong>Número de documento: </strong> " + numero_documento + " "
                   +"<br>"
			      +  "      </div>" 
			     +   "   </div>" 
			     +   "</body>";
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente";
			}else {
				return "No se pudo enviar";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}
	

	
	private boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
		
	}
}
