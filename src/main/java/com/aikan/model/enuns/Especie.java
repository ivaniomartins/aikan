package com.aikan.model.enuns;



public enum Especie {
	
	CANINA ("CANINA", 1),
	FELINA ("FELINA", 2);

   
	private String cod;
	private int tipo;
	

	
	Especie(String string, int i) {
		
	}





	public String getCod() {
		return cod;
	}



	public void setCod(String cod) {
		this.cod = cod;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public static Especie toEnum(String cod) {
		if (cod==null) {
        return null;
	}
		
		
		
		for(Especie x: Especie.values()) {
			
		   if (cod.equals(x.getCod())){ 
			    return x;
		   }
	    }
		throw new IllegalArgumentException("Id inválido " + cod );
	}
	
	

}
