package com.example.Sheuler_ejercicio.service;

import java.util.concurrent.TimeUnit;

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
	
	public String enviarNotificacionRegistroCuenta(String destinatario, String nombre_completo, String tipo_documento, String numero_documento,String correo, String contrasena ) {

		try {
			TimeUnit.MINUTES.sleep(5);
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
	

    public String actualizarContraseña(String destinatario){
        try{
            String asunto = "Actualiza tu contraseña";
            String cuerpo = ""
                + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
                + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
                + "  <h1 style=\"font-size: 24px; font-weight: bold; color: #333333;\">¡Hola!</h1>\r\n"
                + "  <p style=\"font-size: 16px; color: #555555;\">Es hora de actualizar tu contraseña para mantener tu cuenta segura.</p>\r\n"
                + "  <p style=\"font-size: 16px; color: #555555;\">Te recomendamos hacer esto cada cierto tiempo para proteger tu información.</p>\r\n"
                + "  <p style=\"font-size: 16px; color: #555555;\">Accede a tu cuenta y cambia tu contraseña en la sección de configuración.</p>\r\n"
                + "</div>\r\n"
                + "<div style=\"text-align: center; margin-top: 20px;\">\r\n"
                + "  <a href=\"#\" style=\"font-size: 14px; color: #888888; text-decoration: none;\">Términos y condiciones</a> | \r\n"
                + "  <a href=\"#\" style=\"font-size: 14px; color: #888888; text-decoration: none;\">Política de privacidad</a>\r\n"
                + "</div>\r\n"
                + "</body>";


            

            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                return "No se pudo envíar";
            }

        }catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar "+e.getMessage();
        }
    }
    
    public String iniciosesionNotificar(String destinatario){
        try{
            String asunto = "Inicia sesión para evitar el bloqueo de tu cuenta";
            String cuerpo = ""
                + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
                + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
                + "  <h1 style=\"font-size: 24px; font-weight: bold; color: #333333;\">¡Hola!</h1>\r\n"
                + "  <p style=\"font-size: 16px; color: #555555;\">Para mantener tu cuenta activa, por favor inicia sesión regularmente.</p>\r\n"
                + "  <p style=\"font-size: 16px; color: #555555;\">Si no inicias sesión en los próximos días, tu cuenta podría ser bloqueada.</p>\r\n"
                + "  <p style=\"font-size: 16px; color: #555555;\">Accede ahora y evita cualquier inconveniente.</p>\r\n"
                + "</div>\r\n"
                + "<div style=\"text-align: center; margin-top: 20px;\">\r\n"
                + "  <a href=\"#\" style=\"font-size: 14px; color: #888888; text-decoration: none;\">Términos y condiciones</a> | \r\n"
                + "  <a href=\"#\" style=\"font-size: 14px; color: #888888; text-decoration: none;\">Política de privacidad</a>\r\n"
                + "</div>\r\n"
                + "</body>";

            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                return "No se pudo envíar";
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
