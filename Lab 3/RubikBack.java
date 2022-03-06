class RubikBack extends RubikFront {

    private final Rubik rubik;

    RubikBack(Rubik rubik) {
        super(rubik.getGrid());
        this.rubik = rubik;
    }   
    
    @Override
    Rubik left() {
        return this.rubik.backView().left().backView();
    }   

    @Override
    Rubik right() {
        return this.rubik.backView().right().backView();
    }   

    @Override
    Rubik half() {
        return this.rubik.backView().half().backView();
    }   
}

