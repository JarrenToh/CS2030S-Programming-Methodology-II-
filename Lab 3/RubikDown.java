class RubikDown extends RubikFront {

    private final Rubik rubik;

    RubikDown(Rubik rubik) {
        super(rubik.getGrid());
        this.rubik = rubik;
    }   
    
    @Override
    Rubik left() {
        return this.rubik.downView().left().upView();
    }   

    @Override
    Rubik right() {
        return this.rubik.downView().right().upView();
    }   

    @Override
    Rubik half() {
        return this.rubik.downView().half().upView();
    }   
}

