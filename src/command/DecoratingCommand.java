package command;

import businessobjects.ClothTemplate;

public interface DecoratingCommand {
    ClothTemplate decorate(ClothTemplate clothTemplate, String option1, String option2);
}
