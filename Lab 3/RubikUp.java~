class RubikUp extends RubikFront {

    private final Rubik rubik;

    RubikUp(Rubik rubik) {
        super(rubik.getGrid());
        this.rubik = rubik;
    }

    @Override
    Rubik left() {
        return this.rubik.upView().left().downView();
    }
    
    @Override
    Rubik right() {
        return this.rubik.upView().right().downView();
    }
    
    @Override
    Rubik half() {
        return this.rubik.upView().half().downView();
    }
}
