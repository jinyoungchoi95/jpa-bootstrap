package hibernate.action;

import java.util.Queue;

public class ActionQueue {

    private final Queue<EntityInsertAction<?>> insertions;
    private final Queue<EntityUpdateAction<?>> updates;
    private final Queue<EntityDeleteAction<?>> deletions;

    public ActionQueue(
            final Queue<EntityInsertAction<?>> insertions,
            final Queue<EntityUpdateAction<?>> updates,
            final Queue<EntityDeleteAction<?>> deletions
    ) {
        this.insertions = insertions;
        this.updates = updates;
        this.deletions = deletions;
    }

    public void addAction(final EntityInsertAction<?> action) {
        insertions.add(action);
    }

    public void addAction(final EntityUpdateAction<?> action) {
        updates.add(action);
    }

    public void addAction(final EntityDeleteAction<?> action) {
        deletions.add(action);
    }
}
