/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    
    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
        /*for (Resume res: storage
             ) {
            if (res != null) res = null;
        }*/
    }

    void save(Resume r) {
        if (storage[0] == null) {
            storage[0] = r;
        } else
            for (int i = 1; i < storage.length; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                    break;
                }
            }
    }


    //Добить этот метод, чтоб null не возвращал.
    Resume get(String uuid) {
        Resume gotResume = new Resume();
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) gotResume = storage[i];
        }
        return gotResume;
    }

    void delete(String uuid) {
        Resume gotResume;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    //далее передвигаем элементы влево
                    for (int j = i; j < storage.length; j++) {
                        if (storage[j + 1] != null) {
                            storage[j] = storage[j + 1];
                            storage[j + 1] = null;
                        } else break;
                    }
                }
            } else break;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        Resume[] res = new Resume[size];
        for (int i = 0; i < size; i++) {
            res[i] = storage[i];
        }

        return res;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) count++;
            else break;
        }
        /*for (Resume r : storage
        ) {
            if (r != null) count++;
        }*/
        return count;
    }
}
