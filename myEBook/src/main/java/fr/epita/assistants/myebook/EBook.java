package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class EBook implements IPaginated, IEditable {
    private final String name;
    public final List<String> pages;
    private int currentPage;

    public EBook(String name, List<String> pages, int currentPage) {
        this.name = name;
        this.pages = pages;
        this.currentPage = currentPage;
        if (pages.size() == 0)
            this.pages.add("");
    }

    public EBook(String name) {
        this.name = name;
        this.pages = new ArrayList<>();
        this.pages.add("");
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
    public void writeCurrentPage(String pageText) {
        if (currentPage >= 0 && currentPage < pages.size()) {
            pages.set(currentPage, pageText);
        }
    }


    public EBook deepCopy() {
        List<String> pages1 = new ArrayList<>(pages);
        return new EBook(this.name, pages1, this.currentPage);
    }


    @Override
    public void addPage() {
        pages.add(currentPage + 1, "");
    }

    @Override
    public void deletePage()
    {
        pages.remove(currentPage);
        if (pages.size() == 0)
            this.pages.add("");
    }

    public Book print()
    {
        List<String> pages1 = new ArrayList<>(pages);
        return new Book(name, pages1);
    }
}