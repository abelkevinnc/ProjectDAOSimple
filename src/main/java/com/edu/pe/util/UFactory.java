package com.edu.pe.util;

import java.util.Hashtable;
import java.util.ResourceBundle;

//4.4.3 Combinar el factory method con el singleton pattern
//El lector habrá notado que en los DAOs no hemos utilizado variables de instancia. Esto
//significa que, probablemente, una misma y única instancia de cada uno de ellos será
//sufi ciente para acceder a las tablas de la base de datos.
//Siendo así, tendremos que modifi car el método getInstancia de la clase UFactory
//ya que este siempre retorna una nueva instancia del objeto que se le solicita.
//El problema que se presenta es que, como el mismo método es capaz de instanciar objetos
//de diferentes clases identifi cados por un string (objName), tendremos que mantener
//potencialmente varios objetos estáticos. La solución será utilizar una hashtable.
//La clase Hashtable representa una estructura de datos que permite asociar un objeto
//con una clave (key), generalmente un string. Hashtable provee métodos para acceder a
//un objeto especifi cando su clave.
public class UFactory {

	private static Hashtable<String, Object> instancias = new Hashtable<String, Object>();

	public static Object getInstancia(String objName) {
		try {
			// verifico si existe un objeto relacionado a objName
			// en la hashtable
			Object obj = instancias.get(objName);
			// si no existe entonces lo instancio y lo agrego
			if (obj == null) {
				ResourceBundle rb = ResourceBundle.getBundle("factory");
				String sClassname = rb.getString(objName);
				obj = Class.forName(sClassname).newInstance();
				// agrego el objeto a la hashtable
				instancias.put(objName, obj);
			}
			return obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
