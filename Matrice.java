import java.util.*;

public class Matrice {
    private float [][] p_matrice;
    private int p_ligne, p_colonne;

    Matrice() {
        p_ligne = 0;
        p_colonne = 0;
        
        p_matrice = new float[p_ligne][p_colonne];

        
    }

    Matrice(int _ligne, int _colonne) {
        p_ligne = _ligne;
        p_colonne = _colonne;

        p_matrice = new float[p_ligne][p_colonne];
    }

    public Matrice produit(Matrice _mat) {
        // produit matriciel
        Matrice m;

        if(this.p_colonne != _mat.getLigne()) {
            m = new Matrice();
            System.err.println("Error : les deux matrices sont incompatibles, produit matriciel impossible");
        } else {
            m = new Matrice(this.p_ligne, _mat.getColonne());
            for (int i = 0; i < this.p_ligne; i++) {
                for (int j = 0; j < _mat.getColonne(); j++) {
                    float val = 0;
                    for (int k = 0; k < this.p_colonne; k++) {
                        val += this.obtenirValeur(i,k) * _mat.obtenirValeur(k,j);
                        System.out.println(val);
                    }
                    m.insererValeur(i,j,val);
                }
            }
            return m;
        }
        return m;
    }

    public void affiche() {
        //Affiche une matrice        
        for (int i = 0; i < p_matrice.length; i++) {
            //Parcours les lignes
            for (int j = 0; j < p_matrice[i].length; j++) {
                //Parcours les colonnes
                System.out.printf("%.2f ",p_matrice[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    
    public int getLigne() {        
        return p_ligne;
    }

    public int getColonne() {
        return p_colonne;
    }

    public void insererValeur(int _ligne, int _colonne, float _valeur) {
        this.p_matrice[_ligne][_colonne] = _valeur;
    }

    public float obtenirValeur(int _ligne, int _colonne) {
        return this.p_matrice[_ligne][_colonne];
    }

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        System.out.println("-- SAISIE DES DIMENSIONS DE LA 1ERE MATRICE --");
        System.out.print("Entrer le nombre de ligne : ");
        int nb_ligne = clavier.nextInt();
        System.out.print("\nEntrer le nombre de colonne : ");
        int nb_colonne = clavier.nextInt();

        Matrice m1 = new Matrice(nb_ligne,nb_colonne);

        
        System.out.println("\n-- SAISIE DES ELEMENTS DE LA 1ERE MATRICE--\n");
        
        for (int i = 0; i < m1.getLigne(); i++) {
            //Parcours la ligne
            for (int j = 0; j < m1.getColonne(); j++) {
                System.out.printf("Entrer l'élément de ligne %d colonne %d : ", i+1, j+1);
                float val = clavier.nextFloat();
                m1.insererValeur(i,j,val);
            }
            System.out.println();
        }        

        System.out.println("\n-- AFFICHAGE DE LA MATRICE --\n");

        m1.affiche();

        System.out.println("-- SAISIE DES DIMENSIONS DE LA 2EME MATRICE --");
        System.out.print("Entrer le nombre de ligne : ");
        nb_ligne = clavier.nextInt();
        System.out.print("\nEntrer le nombre de colonne : ");
        nb_colonne = clavier.nextInt();
        Matrice m2 = new Matrice(nb_ligne,nb_colonne);

        
        System.out.println("\n-- SAISIE DES ELEMENTS DE LA 2EME MATRICE--\n");
        
        for (int i = 0; i < m1.getLigne(); i++) {
            //Parcours la ligne
            for (int j = 0; j < m1.getColonne(); j++) {
                System.out.printf("Entrer l'élément de ligne %d colonne %d : ", i+1, j+1);
                float val = clavier.nextFloat();
                m2.insererValeur(i,j,val);
            }
            System.out.println();
        }

        System.out.println("\n-- AFFICHAGE DE LA MATRICE --\n");

        m2.affiche();

        Matrice m = m1.produit(m2);

        m.affiche();

        clavier.close();
    }
}
