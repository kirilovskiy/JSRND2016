package home.eighteenth.command;

public class Document {
	private StringBuffer currDocument = new StringBuffer("");
	
	public void Operation(String command, String tmpStr){
		switch(command){
			case "del" : { currDocument.delete(0, tmpStr.length()); break;}
			case "add" : { currDocument = new StringBuffer(tmpStr).append(currDocument); break;}
		}
		System.out.println("Operand ["+ tmpStr +"]; Operation [ "+ command + " ]: result = "+ currDocument.toString()); 	
	}

}
