/**
 * Annie Koshy
 * CSCE 247
 * Decorator
 * Nose Class
 * adds a nose to the character
 */
import java.util.ArrayList;

public class Nose extends CharacterDecorator{

    public Nose(Character character){
        super(character);
        ArrayList<String> decor = FileReader.getLines("designpatterns/decorator/txt/nose.txt");
        integrateDecor(decor);
    }

    @Override
    protected void integrateDecor(ArrayList<String> decor){
        for (int i = 0; i < decor.size(); i++){
            if (i < character.lines.size()){
                String baseLine = character.lines.get(i);
                String decorLine = decor.get(i);
                StringBuilder mergedLine = new StringBuilder(baseLine);
                for (int j = 0; j < decorLine.length() && j < baseLine.length(); j++){
                    if (decorLine.charAt(j) != ' '){
                        mergedLine.setCharAt(j, decorLine.charAt(j));
                    }
                }
                character.lines.set(i, mergedLine.toString());
            } else {
                character.lines.add(decor.get(i));
            }
        }
    }
}