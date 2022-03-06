class RubikLeft extends RubikFront {

    private final Rubik rubik;

    RubikLeft(Rubik rubik) {
        super(rubik.getGrid());
        this.rubik = rubik;
    }   

    @Override
    Rubik left() {
        return this.rubik.leftView().left().rightView();
    }   

    @Override
    Rubik right() {
        return this.rubik.leftView().right().rightView();
    }   

    @Override
    Rubik half() {
        return this.rubik.leftView().half().rightView();
    }   
}

