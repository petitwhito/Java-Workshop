package fr.epita.assistants.myebook;

import java.util.List;

interface IEditable {
    void writeCurrentPage(String pageText);

    void addPage();

    void deletePage();
}

