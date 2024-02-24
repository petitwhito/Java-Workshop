package fr.epita.assistants.myebook;

interface IPaginated {
    void openToPage(int page);

    int getCurrentPage();

    int getPageCount();
}