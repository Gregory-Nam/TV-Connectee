package fr.univ_amu.iut;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.sql.*;

/**
 * 
 */
public class BaseDeDonnee {


    Vector <Utilisateur> users = new Vector<>();
    Vector <InformationImportante> infos = new Vector<>();
    Vector<ListNote> VectorListNotes = new Vector<>();
    String matiereDeNote ="";

    /**
     * Base de donnée contient les vecteurs de toutes les classes "données"
     */
    public BaseDeDonnee() {

        insererDansBD(new InformationImportante("Rattrapage du partiel de graphe samedi matin",0,0,true,0));
        insererDansBD(new InformationImportante("Groupe 3, 8h15-10h15 déplacé à 10h15-12h15",0,0,true,0));
    }

    public String getMatiereDeNote() {
        return matiereDeNote;
    }

    public void setMatiereDeNote(String matiereDeNote) {
        this.matiereDeNote = matiereDeNote;
    }

    /**
     * @param mdp
     * @param mdp
     * @return
     */
    public boolean verificationUtilisateur(String email, String mdp) {
        for (int i = 0; i < users.size(); i++) {
            if (users.elementAt(i).email.equals(email) && users.elementAt(i).mdp.equals(mdp))
            {
//                System.out.println("Connection");
                return true;
            }
        }
//        System.out.println("Connection Fail");
        return false;
    }

    public void insererDansBD(Utilisateur user) {

        users.add(user);
    }
    public void insererDansBD(InformationImportante info) {

        infos.add(info);
    }
    public Vector<InformationImportante> getInfos() {
        return infos;
    }

    public Vector<ListNote> getVectorListNotes() {
        return VectorListNotes ;
    }

    public void insererDansBD(ListNote info) {

        VectorListNotes.add(info);
    }
    public void insererDansBDUtilisateur (String url) {
        //créer une instance workbook qui fait référence au fichier xlsx
        FileInputStream fichier = null;
        try {
            fichier = new FileInputStream(new File(url));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(fichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = wb.getSheetAt(0);

        FormulaEvaluator formulaEvaluator =
                wb.getCreationHelper().createFormulaEvaluator();

        List<String> listeNom = new ArrayList<>();
        Vector<List<String>> vectorUtilisateur = new Vector<>();
        int increment = 0;
        for (Row ligne : sheet) {//parcourir les lignes
            increment = increment + 1;
            for (Cell cell : ligne) {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue() + "\t");
                        listeNom.add(cell.getStringCellValue());
                        break;
                }

            }

        }
        for (int i = 0; i < listeNom.size(); i=i+2) {
            insererDansBD(new Etudiant(listeNom.get(i), listeNom.get(i+1), "Informatique", 3,1));
        }
    }

}