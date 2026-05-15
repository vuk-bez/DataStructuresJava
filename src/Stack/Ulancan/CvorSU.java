package Stack.Ulancan;

public class CvorSU {
    int info;
    CvorSU next;
    CvorSU prev;

    public CvorSU() {
        this.info = 0;
        this.next = null;
        this.prev = null;
    }
    public CvorSU(int info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }
    public CvorSU(int info, CvorSU next) {
        this.info = info;
        this.next = next;
        this.prev = null;
    }
    public int getInfo() {
        return this.info;
    }
    public void setInfo(int info) {
        this.info = info;
    }
    public CvorSU getNext() {
        return this.next;
    }
    public void setNext(CvorSU next) {
        this.next = next;
    }
    public CvorSU getPrev() {
        return this.prev;
    }
    public void setPrev(CvorSU prev) {
        this.prev = prev;
    }
}


