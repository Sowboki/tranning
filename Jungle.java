import java.util.Random;
class Animal {
    //Attribut
    boolean vivant;
    int age;
    String nom;
    int faim;
    int taille;
    String sexe;
    static final int ageReproduction = 4;//mon choix
 // Constructeur Animal
    public Animal(String nom,int age,int taille,String sexe) {
        this.nom=nom;
        this.age=age;
        vivant= true;
        faim= 10;
        this.taille=taille;
        this.sexe=sexe;
    }
    // Methode affichage
    public void affichage() {
        System.out.println("je suis un Nouvel animal;\n Je m'appelle " +nom+ ", j'ai " +age+ " ans.");
    }
    public void mourirFaim() {
        vivant = false;
        System.out.println(nom + " est mort de faim.\n");
    }

    //Methode vieillir
    public void vieillir() {
        age++;
        faim+=10;
        if(faim>=150){
            mourirFaim();
        }
    }
    public void crier() {
        if (nom.equals("Mouton")) {
            System.out.println("Mbééé Mbééé.");
        } else if (nom.equals("Chien")) {
            System.out.println("Waff Waff.");
        } else if (nom.equals("Lion")) {
            System.out.println("Gra Gra Gra.");
        } else {
            System.out.println("Cri génerique de l'animal.");
        }
    }
    
    // Methode mourir
    public void mourir() {
        vivant=false;
    }
    //Methode vieillir avec paramêtre année
    public void vieillir(int annees) {
        age+=annees;
        faim+= 10 * annees;
        if (faim >= 10) {
            mourirFaim();
        }
    }
    public void manger(int Nouriture){
        faim-=Nouriture;
        if(faim<0){
            faim=0;
        }
    }

    
    public void reproduire(Animal partenaire) {
        if (this.vivant && partenaire.vivant && this.age >= ageReproduction
            && partenaire.age>=ageReproduction && this.nom.equals(partenaire.nom)
            && !this.sexe.equals(partenaire.sexe)) {
            int nouvelNaissanceAge=0;
            Animal nouveauNe =new Animal(this.nom, nouvelNaissanceAge, this.taille, "M");
            System.out.println(this.nom+" et "+partenaire.nom + " ont eu une nouvelle naissance: " + nouveauNe.nom);
        }
    }
}
class Carnivore extends Animal {
    public Carnivore(String nom,int age) {
        super(nom, age,0, "M");

    }

    public void chasser(Animal a) {
        if (a instanceof Herbivore) {
            System.out.println(nom+ " chasse " +a.nom);
            a.mourir();
        } else {
            System.out.println(nom+ " ne peut pas chasser " +a.nom);
        }
    }
}

class Herbivore extends Animal {
    public Herbivore(String nom,int age) {
        super(nom,age,0,"F");
    }

    public void brouter() {
        System.out.println(nom + " broutes de l'herbe.");
        faim -= 15; 
        if (faim < 0) {
            faim = 0;
        }
    }
}
public class Jungle {
   // static Animal[] animaux=new Animal[]{new Animal("Lion",10), new Animal("Serpent",5), new Animal("Mouton",9)};
    static Animal[] animaux = new Animal[]{new Carnivore("Lion", 10),new Carnivore("Chien", 7),new Carnivore("Serpent", 5),new Herbivore("Mouton", 9)};

    public static void interaction() {
        Random choix=new Random();
        int action=choix.nextInt(3);

        if (action==0) {
            int indexAnimal1=choix.nextInt(animaux.length);
            int indexAnimal2= choix.nextInt(animaux.length);

            while (indexAnimal2== indexAnimal1) {
                indexAnimal2 =choix.nextInt(animaux.length);
            }

            Animal animal1 =animaux[indexAnimal1];
            Animal animal2=animaux[indexAnimal2];

            if (animal1.age >animal2.age) {
                double defendre=Math.random();
                if (defendre <0.5) {
                    animal2.mourir();
                    System.out.println(animal1.nom+" a tué "+animal2.nom + ".\n");
                } else {
                    System.out.println(animal2.nom+" a survécu à l'attaque de "+animal1.nom+".\n");
                }
            } else {
                double defendre=Math.random();
                if (defendre<0.5) {
                    animal1.mourir();
                    System.out.println(animal2.nom + " a tué " + animal1.nom + ".\n");
                } else {
                    System.out.println(animal1.nom + " a survécu à l'attaque de " + animal2.nom + ".\n");
                }
            
             }} else if (action==1) {
            int indexAnimal1= choix.nextInt(animaux.length);
            int indexAnimal2=choix.nextInt(animaux.length);
//////////
            while (indexAnimal2==indexAnimal1) {
                indexAnimal2=choix.nextInt(animaux.length);
            }
//////////
            Animal animal1=animaux[indexAnimal1];
            Animal animal2=animaux[indexAnimal2];

            if (animal1.nom.equals(animal2.nom)) {
                Animal nouveauNee;
                int nouvelleNaissanceAge=0;
                if (animal1 instanceof Carnivore) {
                    nouveauNee=new Carnivore(animal1.nom, nouvelleNaissanceAge);
                } else {
                    nouveauNee=new Herbivore(animal1.nom, nouvelleNaissanceAge);
                }
                System.out.println("Une nouvelle naissance: " + nouveauNee.nom);
            
            }
        }
    }
    //Methode passage du temps .
    public static void passageDuTemps() {
        for (Animal animal : animaux) {
            animal.manger(20); 
            animal.vieillir(); 
        }
        
        for (Animal animal : animaux) {
            if (animal instanceof Carnivore && animal.faim >= 40) {
                for (Animal proie : animaux) {
                    if (proie instanceof Herbivore && proie.vivant && proie.taille < animal.taille) {
                        ((Carnivore) animal).chasser(proie);
                        System.out.println(animal.nom+ " a mangé " +proie.nom);
                        break;
                    } else {
                        System.out.println(animal.nom+ " ne peut pas manger "+ proie.nom);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();


        for (int jour = 1; jour <= 6; jour++) {
            System.out.println("Jour " + jour);

            for (Animal animal : animaux) {
                animal.affichage();
                animal.manger(20);
                animal.vieillir();
                animal.crier();
                animal.reproduire(animaux[random.nextInt(animaux.length)]);
                if (animal instanceof Carnivore && animal.faim >= 40) {
                    for (Animal proie : animaux) {
                        if (proie instanceof Herbivore && proie.vivant && proie.taille < animal.taille) {
                            ((Carnivore) animal).chasser(proie);
                            System.out.println(animal.nom+ " a mangé " +proie.nom);
                            break;
                        }
                    }
                }
                if (animal.faim >= 10) {
                    animal.mourirFaim();
                }
            }
        }
    }

}
