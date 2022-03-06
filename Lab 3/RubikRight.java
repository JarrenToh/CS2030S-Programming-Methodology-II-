class RubikRight extends RubikFront {

    private final Rubik rubik;

    RubikRight(Rubik rubik) {
        super(rubik.getGrid());
        this.rubik = rubik;
    }   
    
    @Override
    Rubik left() {
        return this.rubik.rightView().left().leftView();
    }   

    @Override
    Rubik right() {
        return this.rubik.rightView().right().leftView();
    }   

    @Override
    Rubik half() {
        return this.rubik.rightView().half().leftView();
    }   
}

