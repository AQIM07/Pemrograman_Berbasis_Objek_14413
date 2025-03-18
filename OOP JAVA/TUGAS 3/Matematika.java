    class Matematika {
        // Method untuk operasi matematika
        public int pertambahan(int a, int b) {
            return a + b;
        }
        
        public int pengurangan(int a, int b) {
            return a - b;
        }
        
        public int perkalian(int a, int b) {
            return a * b;
        }
        
        public int pembagian(int a, int b) {
            if (b != 0) {
                return a / b;
            } else {
                System.out.println("Pembagian dengan nol tidak diperbolehkan.");
                return 0;
            }
        }
    }

    class MatematikaDemo {
        public static void main(String[] args) {
            Matematika math = new Matematika();
            
            // Menampilkan hasil operasi matematika
            System.out.println("Pertambahan: 22 + 19 = " + math.pertambahan(22, 19));
            System.out.println("Pengurangan: 22 - 11 = " + math.pengurangan(22, 11));
            System.out.println("Perkalian: 22 x 22 = " + math.perkalian(22, 22));
            System.out.println("Pembagian: 22 / 2 = " + math.pembagian(22, 2));
        }
    }
