package BinarySearchTree;

public class BST {
    private static class Cvor {
        int kljuc;
        Cvor lijevi;
        Cvor desni;

        public Cvor(int kljuc) {
            this.kljuc = kljuc;
            this.lijevi = null;
            this.desni = null;
        }

        public Cvor(int kljuc, Cvor desni, Cvor lijevi) {
            this.kljuc = kljuc;
            this.lijevi = lijevi;
            this.desni = desni;
        }

        public int getKljuc() {
            return kljuc;
        }

        public void setKljuc(int kljuc) {
            this.kljuc = kljuc;
        }

        public Cvor getLijevi() {
            return lijevi;
        }

        public void setLijevi(Cvor lijevi) {
            this.lijevi = lijevi;
        }

        public Cvor getDesni() {
            return desni;
        }

        public void setDesni(Cvor desni) {
            this.desni = desni;
        }
    }

    Cvor korijen;

    public BST() {
        korijen = null;
    }

    public void insert(int kljuc) {
        korijen = insertRec(korijen, kljuc);
    }

    private Cvor insertRec(Cvor korijen, int kljuc) {
        if(korijen == null) {
            korijen = new Cvor(kljuc);
            return korijen;
        }
        if (kljuc < korijen.getKljuc()) {
            korijen.setLijevi(insertRec(korijen.lijevi, kljuc));
        } else if (kljuc > korijen.getKljuc()) {
            korijen.setDesni(insertRec(korijen.desni, kljuc));
        }

        return korijen;
    }

    public void delete(int kljuc) {
        korijen = deleteRec(korijen, kljuc);
    }

    private Cvor deleteRec(Cvor korijen, int kljuc) {
        if(korijen == null) {
            return korijen;
        }
        if (kljuc < korijen.getKljuc()) {
            korijen.setLijevi(deleteRec(korijen.lijevi, kljuc));
        } else if (kljuc > korijen.getKljuc()) {
            korijen.setDesni(deleteRec(korijen.desni, kljuc));
        } else {
            if (korijen.lijevi == null) {
                return korijen.desni;
            }
            else if (korijen.desni == null) {
                return korijen.lijevi;
            }

            korijen.kljuc = minValue(korijen.desni);
            korijen.desni = deleteRec(korijen.desni, korijen.desni.getKljuc());
        }

        return korijen;
    }

    private int minValue(Cvor desni) {
        Cvor temp = desni;
        int minv = temp.getKljuc();
        while (temp.getLijevi() != null) {
            minv = temp.getLijevi().getKljuc();
            temp = temp.getLijevi();
        }
        return minv;
    }

    public boolean search(int kljuc) {
        return searchRec(korijen, kljuc);
    }

    private static boolean searchRec(Cvor korijen, int kljuc) {
        if (korijen == null) {
            return false;
        }
        if (kljuc < korijen.getKljuc()) {
            return searchRec(korijen.lijevi, kljuc);
        }
        if (kljuc > korijen.getKljuc()) {
            return searchRec(korijen.desni, kljuc);
        }
        if (kljuc == korijen.getKljuc()) {
            return true;
        }
        return false;
    }

    public void inorder() {
        inorderRec(korijen);
        System.out.println();
    }

    private void inorderRec(Cvor korijen) {
        if (korijen != null) {
            inorderRec(korijen.lijevi);
            System.out.print(korijen.getKljuc() + " ");
            inorderRec(korijen.desni);
        }
    }



}
