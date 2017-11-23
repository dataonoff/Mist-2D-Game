package game.gameObject.player;

public enum Actions {
    NULL,
    JUMP,
    WALK,
    LIFT,
    SIMPLE_JUMP(Actions.JUMP),
    JUMP_RIGHT(Actions.JUMP),
    JUMP_LEFT(Actions.JUMP),
    WALK_RIGHT(Actions.WALK),
    WALK_LEFT(Actions.WALK),
    LIFT_UP(Actions.LIFT),
    LIFT_DOWN(Actions.LIFT),
    DOBLE_JUMP(Actions.JUMP),
    ATTACK,
    FALLING,
    IDLE;

    Actions parent;

    Actions() {
        this.parent = null;
    }

    Actions(Actions parent) {
        this.parent = parent;
    }

    public Actions getParent() {
        return (this.parent == null ? Actions.NULL : this.parent);
    }
}
