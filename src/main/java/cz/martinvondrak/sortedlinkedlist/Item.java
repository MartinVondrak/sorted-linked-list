package cz.martinvondrak.sortedlinkedlist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
class Item<T extends Comparable<T>> {
    private final T value;
    @Setter
    private Item<T> next;
}
