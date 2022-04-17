/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        int variableForLoop = size;
        for (int i = 0; i < variableForLoop; i++) {
            storage[i] = null;
            size--;
        }
    }

    void save(Resume r) {
        if (r.uuid == null) return;
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        Resume gotResume;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                //далее передвигаем элементы влево
                for (int j = i; j < size; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[size] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return size;
    }
}