package net.local.dddpoc.catalog.application.usecases.category;

import java.util.UUID;

import net.local.dddpoc.catalog.application.domain.category.entities.Category;
import net.local.dddpoc.catalog.application.domain.category.entities.CategoryId;
import net.local.dddpoc.catalog.application.domain.category.entities.Title;
import net.local.dddpoc.catalog.application.domain.category.entities.Uri;
import net.local.dddpoc.catalog.application.domain.category.repositories.SaveCategoryPort;

public class CreateCategoryUC {
    
    private final SaveCategoryPort saveCategoryPort;

    public CreateCategoryUC(SaveCategoryPort saveCategoryPort) {
        this.saveCategoryPort = saveCategoryPort;
    }

    public void execute(String title, String uri) {
        var newCategory = new InputCategory(new CategoryId(UUID.randomUUID()), new Uri(uri), new Title(title));

        saveCategoryPort.save(newCategory);
    }

    public record InputCategory(CategoryId id, Uri uri, Title title) implements Category{} 
}