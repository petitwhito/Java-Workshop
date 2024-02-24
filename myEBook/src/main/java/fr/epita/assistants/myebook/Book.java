package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class Book implements IPaginated, IReadable {
    public final String name;
    public final List<String> pages;
    private int currentPage;

    // Only accessible by EBook
    Book(String name, List<String> pages) {
        this.name = name;
        this.pages = pages;
        this.currentPage = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public void openToPage(int page) {
        if (page >= 0 && page < pages.size()) {
            currentPage = page;
        }
    }

    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public int getPageCount() {
        return pages.size();
    }

    @Override
    public String readCurrentPage() {
        if (currentPage >= 0 && currentPage < pages.size()) {
            return pages.get(currentPage);
        }
        return null;
    }

    public EBook scan()
    {
        List<String> pages1 = new ArrayList<>(pages);
        return new EBook(name, pages1, currentPage);
    }

}
