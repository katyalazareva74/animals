package file;

import java.io.IOException;

public interface OutInput {

    void save(Object zoo);

    Object load() throws ClassNotFoundException, IOException;
}
