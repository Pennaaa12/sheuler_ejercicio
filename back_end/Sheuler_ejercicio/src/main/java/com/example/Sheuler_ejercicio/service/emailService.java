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
	
	public String enviarNotificacionCuenta(String destinatario, String numero_documento, String correo, String contrasena ) {

		try {
			
			String asunto="Bienvenid@ " +numero_documento + " a AsignaWeb";
			String cuerpo=""
					+"<body style='margin: 0; padding: 0; background-color: #CCCCCC;'>" 
			      +  "  <div style='background-color: #CCCCCC;'>" 
			       + "   <div style='background-color: white; max-width: 600px; margin: auto; padding: 20px; box-sizing: border-box;'>" 
			   +     "       <div style='background-color: #202C4A; padding: 11px; text-align: center;'>" 
			    +    "           <img style='width: 110px; height: 100px;' src='https://i.postimg.cc/L8hJKpjP/5613765-Recuperado.png' alt='Logo'>" 
			    +    "       </div>" 
			      +  "<h1 style='color: #2B56C5; text-align: center; font-size: 24px; margin-top: 20px;'>¡Bienvenid@, " + numero_documento + " a AsignaWeb!</h1>"

			    +    "      <p style='color: #000; font-size: 16px; line-height: 1.5; margin-top: 20px;'>" 
			      +  "          Explora nuestra plataforma dedicada a facilitar la reserva" 
			     +   "          de sitios educativos de manera eficiente y conveniente. Con AsignaWeb," 
			     +   "          encontrarás la herramienta perfecta para gestionar tus reservas escolares" 
			    +    "          de manera sencilla, asegurando que cada visita educativa sea organizada" 
			    +    "          y productiva. Descubre cómo podemos simplificar la planificación de tus" 
			    +    "          actividades educativas. ¡Bienvenido a una nueva forma de reservar con AsignaWeb!" 
			    +    "      </p>" 
			   +     "      <br>" 
			       + "    <center>" 
			   +" <strong> Tus credenciales son las siguientes: </strong>"
			       +"<br>"
			       +"<br>"
			       
                   + "          <strong>Nombre de Usuario: </strong> " + correo + " "
                   +"<br>"
                   + "          <strong>Contraseña: " + contrasena + "</strong>"
                   +"<br>"
                        
			     
			      +  "         <a href='http://127.0.0.1:5502/HtmlYCss/indexHTML/index.html' style='text-decoration: none;'>" 
			      +  "             <button style='background-color:#2B56C5; color:white; padding:10px 20px; border:none; border-radius:14px; font-size:16px; cursor:pointer; margin-bottom:3%; margin-top:3%;'>Inicio de sesión</button>" 
			      +  "         </a>" 
			     +   "    </center>" 
			     +   "       <p style='text-align:center; font-size: 16px;'>¡Te esperamos pronto!</p>" 
			      +  "       <div style='background-color: #202C4A; margin: auto; padding: 35px;'>" 
			      +  "       </div>" 
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
