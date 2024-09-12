import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Magasin {
    private int tresorerie;
    private double montantLoyer;
    private List<Instrument> stockInstruments;

    Magasin(int tresorerie, double montantLoyer) {
        this.tresorerie=tresorerie;
        this.montantLoyer=montantLoyer;
        stockInstruments =new ArrayList<>();
    }
   
    public void ajouterInstrument(Instrument instrument) {
        stockInstruments.add(instrument);
    }

    public void retirerInstrument(Instrument instrument) {
        stockInstruments.remove(instrument);
    }

    public List<Instrument> obtenirStockInstruments() {
        return stockInstruments;
    }
//Classe Intruments
    class Instrument {
        String nom;
        double prixAchat;
        double prixVente;

        Instrument(String nom, double prixAchat,double prixVente) {
            this.nom = nom;
            this.prixAchat = prixAchat;
            this.prixVente = prixVente;
        }

        void ficheTechnique() {
            System.out.println("Nous avons un " + nom + ".J'ai acheté cet instrument à " +prixAchat + " euros.");
            System.out.println("Je revends cet instrument à " + prixVente+ " euros.");
        }
    }

    class InstrumentACordes extends Instrument {
        double longueur;
        double largeur;

        InstrumentACordes(String nom,double prixAchat,double prixVente,double longueur, double largeur) {
            super(nom, prixAchat, prixVente);
            this.longueur=longueur;
            this.largeur=largeur;
        }

    
        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Longueur : " +longueur + " cm");
            System.out.println("Largeur: "+largeur +" cm");
        }
    }

    class Piano extends InstrumentACordes {
        int nombreTouches = 88;
        Piano(String nom,double prixAchat,double prixVente, int nombreTouches,double longueur,double largeur) {
            super(nom, prixAchat,prixVente, longueur, largeur);
            this.nombreTouches =nombreTouches;
        }

        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Nombre de touches : " + nombreTouches);
        }
    }

    class PianoNumerique extends Piano {
        boolean toucherLourd;
        int qualiteEchantillonnage;

        PianoNumerique(String nom, double prixAchat, double prixVente, int nombreTouches, double longueur, double largeur, boolean toucherLourd, int qualiteEchantillonnage) {
            super(nom, prixAchat, prixVente, nombreTouches, longueur, largeur);
            this.toucherLourd = toucherLourd;
            this.qualiteEchantillonnage =qualiteEchantillonnage;
        }

        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Touche Lourde : "+toucherLourd);
            System.out.println("Qualité Echantillonnage : " +qualiteEchantillonnage);
        }
    }

    class PianoDroit extends Piano {
        boolean cordesDroites;
        boolean silencieux;

        PianoDroit(String nom, double prixAchat, double prixVente,boolean cordesDroites,boolean silencieux) {
            super(nom, prixAchat, prixVente, 88,0,0);
            this.cordesDroites = cordesDroites;
            this.silencieux= silencieux;
        }

        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Cordes Droites : " + cordesDroites);
            System.out.println("Silencieux : " + silencieux);
        }
    }

    enum Taille{QUATRE_QUART,UN_DEMI,UN_QUART,CRAPAUD}
    class PianoQueue extends Piano {
        Taille taille;

        PianoQueue(String nom, double prixAchat, double prixVente, int nombreTouches, Taille taille) {
            super(nom, prixAchat, prixVente, nombreTouches, 0, 0);
            this.taille= taille;
        }
        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Taille : " +taille);
            switch(taille){
                case QUATRE_QUART:
                System.out.println("4/4");
                break;
                case UN_DEMI:
                System.out.println("1/2");
                break;
                case UN_QUART:
                System.out.println("1/4");
                break;
                case CRAPAUD:
                System.out.println("Crapaud");
                break;
            }
        }

    }

    class Guitare extends InstrumentACordes {
        int tirant;

        Guitare(String nom, double prixAchat, double prixVente, double longueur, double largeur, int tirant) {
            super(nom,prixAchat,prixVente,longueur, largeur);
            this.tirant=tirant;
        }
        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Tirant : " +tirant);
        }
    }

    enum Type {
        FLUTE_TRAVERSIERE, CLARINETTE, HAUTBOIS
    }

    class InstrumentAVent extends Instrument {
        Type type;

        InstrumentAVent(String nom,double prixAchat,double prixVente, Type type) {
            super(nom, prixAchat,prixVente);
            this.type= type;
        }
        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Type Instrument : "+ type);
        }
    }

    class FluteTraversiere extends InstrumentAVent {
        boolean possedeTrilles;
        int qualiteAcoustique;

        FluteTraversiere(String nom, double prixAchat, double prixVente, boolean possedeTrilles, int qualiteAcoustique) {
            super(nom, prixAchat, prixVente, Type.FLUTE_TRAVERSIERE);
            this.possedeTrilles = possedeTrilles;
            this.qualiteAcoustique = qualiteAcoustique;
        }
        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Possède Trilles : "+ possedeTrilles);
            System.out.println("Qualité Acoustique : " + qualiteAcoustique);
        }
    }

    enum Utilisation {
        SYMPHONIQUE, CHAMBRE, HARMONIQUE
    }
    class Clarinette extends InstrumentAVent {
        Utilisation utilisation;

        Clarinette(String nom, double prixAchat, double prixVente, Utilisation utilisation) {
            super(nom, prixAchat, prixVente, Type.CLARINETTE);
            this.utilisation = utilisation;
        }


        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println("Utilisation : " + utilisation);
        }
    }

    class Hautbois extends InstrumentAVent {
        Hautbois(String nom,double prixAchat,double prixVente) {
            super(nom,prixAchat,prixVente,Type.HAUTBOIS);
        }

        void ficheTechnique() {
            super.ficheTechnique();
            System.out.println();
        }
    }

    //loyer du mois
    void loyer(double montant){
        System.out.println("Le montant du loyer de ce mois est "+montant+ " Euros");
        tresorerie-=montant;
    }
    // tresorerie
    void tresorerie(int montant){
        tresorerie+=montant;
        System.out.println("La tresorerie du magasin est de " +montant + " Euros");

    }
    // Fournir des instrument au stock
    void fournir(Instrument instrument, int quantite) {
        double coutTotal=instrument.prixAchat* quantite;
    
        if (tresorerie>= coutTotal) {
            for (int i=0; i<quantite;i++) {
                stockInstruments.add(instrument);
            }
            tresorerie -= coutTotal;
            for (int i=0;i<70;i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println("Votre trésorerie est suffisante pour augmenter le stock d'instruments.");
            for (int i=0;i <70; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println("Nouvel instrument : " + instrument.nom + " & Quantité : " + quantite);
        } else {
            for (int i=0; i< 65;i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println("Votre trésorerie est insuffisante pour augmenter votre stock d'instruments.");
            for (int i=0; i< 65;i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    //methode vendre 
    void vendre(Instrument instrument){
        tresorerie+=instrument.prixVente;
        retirerInstrument(instrument);
        System.out.println("l'instrument "+instrument.nom+ " est vendu à "+ instrument.prixVente + " Euros"  );
        System.out.println("L'instument "+instrument.nom + " viens d'être retiré du stock d'instrument.\n");

    }
    // methode simuler fonctionnement magasin 
    enum Mois {JANVIER,FEVRIER,MARS,AVRIL, MAI, JUIN,JUILLET,AOUT,SEPTEMBRE,OCTOBRE,NOVEMBRE,DECEMBRE
      }
    static void simulerFonctionnement(Magasin magasin){
        Random random =new Random();

        for(Mois mois:Mois.values()){
            int tailleStock = magasin.stockInstruments.size();
            if (tailleStock==0) {
                System.out.println("Stock épuisé Plus d'instrument disponibles.");
                break;
            }
            int nombreClient=Math.min(random.nextInt(tailleStock)+1,tailleStock);
            System.out.println("Le nombre de client pour le mois de "+mois+" est : "+nombreClient);
            
            for(int i=0;i<nombreClient;i++){
                if (magasin.stockInstruments.isEmpty()) {
                    System.out.println("Stock épuisé !Plus d'instrument disponibles.");
                    break;
                }
                int indexInstrument = random.nextInt(tailleStock);
                if (indexInstrument >= magasin.stockInstruments.size()) {
                    indexInstrument = magasin.stockInstruments.size() - 1;
                }
                Instrument instrument = magasin.stockInstruments.get(indexInstrument);

                if(instrument.prixVente <=3500){
                    System.out.println("Client: Je vais acheter l'instrument "+ instrument.nom+".");
                    magasin.vendre(instrument);
                }else{
                    System.out.println("Client : Waw L'instrument est vraiment trop cher, je ne peux pas l'acheter.\n");
                }
            }
        }
        

    }
    
    public static void main(String[] args) {
        Magasin magasin = new Magasin(10000, 2000);
//////////////////////////////// 
        Piano piano1 = magasin.new Piano("Piano à queue", 5000.0, 7500.0, 88, 6, 7);
        PianoNumerique pianoNumerique = magasin.new PianoNumerique("Piano Numérique", 3000.0, 4499.99, 88, 5, 6, true, 24);
        PianoQueue pianoQueue = magasin.new PianoQueue("Piano Queue", 3400.0, 5999.99, 88, Magasin.Taille.QUATRE_QUART);
        PianoDroit pianoDroit = magasin.new PianoDroit("Piano Droit", 3000.0, 6499.99, true, false);
    
        Guitare guitare1 = magasin.new Guitare("Guitare classique", 500.0, 799.99, 100.0, 40.0, 12);
        Guitare guitare2 = magasin.new Guitare("Guitare électrique", 800.0, 1499.99, 105.0, 35.0, 9);

    
        FluteTraversiere flute = magasin.new FluteTraversiere("Flute Traversière", 600.0, 999.99, true, 8);
        Clarinette clarinette = magasin.new Clarinette("Clarinette", 700.0, 1299.99, Magasin.Utilisation.SYMPHONIQUE);
        Hautbois hautbois = magasin.new Hautbois("Hautbois", 900.0, 1799.99);
    
/////// Remplissage du stock du magasin
        magasin.ajouterInstrument(piano1);
        magasin.ajouterInstrument(pianoNumerique);
        magasin.ajouterInstrument(pianoQueue);
        magasin.ajouterInstrument(pianoDroit);
        magasin.ajouterInstrument(guitare1);
        magasin.ajouterInstrument(guitare2);
        magasin.ajouterInstrument(flute);
        magasin.ajouterInstrument(clarinette);
        magasin.ajouterInstrument(hautbois);
    
 /////// Liste des instruments actuels
        System.out.println("Liste des instruments actuels :");
        List<Magasin.Instrument> instruments = magasin.obtenirStockInstruments();
        for (Magasin.Instrument instrument :instruments) {
            instrument.ficheTechnique();
            System.out.println();
        }
        System.out.println();
        System.out.println("Liste des instruments actuels :");
        for (Magasin.Instrument instrument : instruments) {
            instrument.ficheTechnique();
            System.out.println();
        }
//////nouvel instrument au stock en utilisant la méthode fournir
        Magasin.Instrument nouvelInstrument =magasin.new Piano("Vangoa",225,500,88,6,7);
        int quantiteNouveau = 3;
        magasin.fournir(nouvelInstrument, quantiteNouveau);
        System.out.println("Liste mise à jour des instruments :");
        instruments = magasin.obtenirStockInstruments();
        for (Magasin.Instrument instrument : instruments) {
            instrument.ficheTechnique();
            System.out.println();
        }
        for (int i = 0; i < 65; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Ajout d'un nouvel instrument au stock :");
        System.out.println("Nouvel instrument : "+ nouvelInstrument.nom);
        System.out.println("Quantité ajoutée : "+ quantiteNouveau);
        
        for (int i = 0; i < 65; i++) {
            System.out.print("-");
        }
        System.out.println();
        
        // Appel  méthode loyer
        magasin.loyer(2000);
        int tresorerieActuelle =magasin.tresorerie;
        System.out.println("La trésorerie du magasin est maintenant de "+ tresorerieActuelle+ " Euros");
        for (int i = 0; i < 65; i++) {
            System.out.print("-");
        }
        System.out.println();

        //fonctionnement du magasin
        simulerFonctionnement(magasin);
        
        
    }
    
    }
    