package fr.univ_amu.iut;

import java.io.FileNotFoundException;
import java.util.*;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;


public class ListNote extends Information {
    /**
     * Vecteur contenant des listes de chaîne de caractère correspondant aux notes.
     *  @see #getVectorListNote()
     */
    private Vector<List<String>> vectorListNote = new Vector<>(3);
    /**
     * Chemin du fichier excel contenant les notes.
     */
    private String path;

    /**
     * Liste contenant les informations des notes.
     * @see #getNoteData()
     */
    private static ObservableList<Note> noteData = FXCollections.observableArrayList();

    /**
     * Déclaration base de données
     */
    private BaseDeDonnee baseDeDonnee;

    /**
     * Constructeur de la classe ListNote
     * @param baseDeDonnee
     * @param path
     */
    public ListNote(BaseDeDonnee baseDeDonnee, String path) {
        this.path = path;
        this.baseDeDonnee = baseDeDonnee;
        createNewListFromPath();
    }

    /**
     * Méthode public void permettant de créer une liste à partir d'un chemin
     */
    public void createNewListFromPath(){


        //créer une instance workbook qui fait référence au fichier xlsx
        FileInputStream fichier = null;
        try {
            fichier = new FileInputStream(new File(path));
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
        Vector<List<String>> notes = new Vector<>();
        List<String> listeNom = new ArrayList<>();
        List<String> listeNote = new ArrayList<>();
        Vector<List<String>> vectorListNote = new Vector<>(3);
        int increment = 0;
        for (Row ligne : sheet) {//parcourir les lignes
            increment = increment + 1;

            for (Cell cell : ligne) {//parcourir les colonnes
                //évaluer le type de la cellule

                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        Double tempDouble = cell.getNumericCellValue();
                        listeNote.add(tempDouble.toString());
                        break;
                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue() + "\t");
                        listeNom.add(cell.getStringCellValue());
                        break;
                }

            }
            notes.add(0, listeNom);
            notes.add(1, listeNote);
//            System.out.println();
        }
        vectorListNote.add(0, listeNom);
        vectorListNote.add(1, listeNote);

//        System.out.println("List : \n");

//        System.out.println(vectorListNote);
        for (int i = 0; i < vectorListNote.get(0).size()-1; i++) {
            noteData.add(new Note(i, vectorListNote));
        }
        baseDeDonnee.insererDansBD(this);

    }

    /**
     * Accesseur du vector de liste contenant les notes.
     * @return vectorListNote
     */
        public Vector<List<String>> getVectorListNote () {
            return vectorListNote;
        }

    /**
     * Accesseur des notes
     * @return noteData
     */
    public ObservableList<Note> getNoteData () {
            return this.noteData;
        }
    }