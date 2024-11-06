public class MyList<T> {
    private T[] array;     // Diziyi tutar
    private int size;      // Listedeki mevcut eleman sayısı
    private int capacity;  // Dizinin kapasitesi

    public MyList() {
        this.capacity = 10;           // İlk kapasiteyi 10 olarak belirleyelim
        this.array = (T[]) new Object[getCapacity()]; // Generic diziyi Object ile başlatıyoruz
        this.size = 0;
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Eleman ekleme metodu
    public void add(T element) {
        if (size == getCapacity()) {
            increaseCapacity();  // Eğer kapasite dolduysa artır
        }
        array[size++] = element; // Elemanı ekleyip size'ı artır
    }

    // Kapasiteyi iki katına çıkarma
    private void increaseCapacity() {
        capacity = getCapacity() * 2;
        T[] newArray = (T[]) new Object[getCapacity()];
        System.arraycopy(array, 0, newArray, 0, size); // Eski diziyi yeniye kopyala
        array = newArray;
    }

    // Eleman sayısını döndürme
    public int size() {
        return size;
    }

    // Belirli bir indisteki elemanı alma
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Geçersiz indeks: " + index);
        }
        return array[index];
    }

    // Belirli bir indisteki elemanı silme
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Geçersiz indeks: " + index);
        }
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1]; // Elemanları bir sola kaydır
        }
        array[--size] = null; // Son elemanı null yap ve size'ı azalt
        return removedElement;
    }

    // Listeyi yazdırma
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int getCapacity() {
        return capacity;
    }
}
