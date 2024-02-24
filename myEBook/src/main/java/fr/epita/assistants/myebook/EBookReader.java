package fr.epita.assistants.myebook;

import fr.epita.assistants.myebook.EBook;
import fr.epita.assistants.myebook.Book;

public class EBookReader implements IPaginated, IReadable, IUpdatable {
    private double firmwareVersion;
    private EBook ebook;
    private int currentPage;

    public EBookReader() {
        this.firmwareVersion = 1.0;
        this.currentPage = 0;
    }

    @Override
    public void openToPage(int page) {
        if (ebook != null) {
            ebook.openToPage(page);
            currentPage = ebook.getCurrentPage();
        }
    }

    @Override
    public int getCurrentPage() {
        return (ebook != null) ? currentPage : -1;
    }

    @Override
    public int getPageCount() {
        return (ebook != null) ? ebook.getPageCount() : -1;
    }

    @Override
    public String readCurrentPage() {
        if (ebook == null)
            return null;
        if (currentPage >= 0 && currentPage < ebook.getPageCount()) {
            return ebook.pages.get(currentPage);
        }
        return null;
    }

    public void openEbook(EBook ebook) {
        this.ebook = ebook.deepCopy();
    }

    @Override
    public double getVersion() {
        return firmwareVersion;
    }

    @Override
    public void update(double version) {
        if (version > firmwareVersion) {
            firmwareVersion = version;
        }
    }


}