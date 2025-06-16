public class MaxHeap {
  private int[] nums;

  public MaxHeap(int size) {
    nums = new int[size];
  }

  private int size;

  public void insert(int value) {
    if (isFull())
      throw new IllegalStateException("Heap is full!");

    nums[size++] = value;
    bubbleUp();
  }

  public int remove() {
    if (isEmpty())
      throw new IllegalStateException("Heap is empty!");

    var root = nums[0];
    nums[0] = nums[--size];
    bubbleDown();

    return root;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  // Inner Details
  private void bubbleDown() {
    var index = 0;

    while (index <= size && !isValidParent(index)) {
      var largerChildIndex = largestChildIndex(index);

      swap(index, largerChildIndex);
      index = largerChildIndex;
    }
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    if (!hasRightChild(index))
      return nums[index] >= leftChild(index);

    return nums[index] >= leftChild(index) && nums[index] >= rightChild(index);
  }


  private int largestChildIndex(int index) {
    if (!hasLeftChild(index))
      return index;

    else if (!hasRightChild(index))
      return leftChildIndex(index);

    return  (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= size;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= size;
  }

  private int leftChild(int index) {
    return nums[leftChildIndex(index)];
  }

  private int rightChild(int index) {
    return nums[rightChildIndex(index)];
  }

  private int leftChildIndex(int index) {
    return (2 * index) + 1;
  }

  private int rightChildIndex(int index) {
    return (2 * index) + 2;
  }

  private void bubbleUp() {
    var currValueIndex = size - 1;
    var parentIndex = parentIndex(currValueIndex);

    while (currValueIndex > 0 && nums[currValueIndex] > nums[parentIndex]) {

      swap(currValueIndex, parentIndex);
      currValueIndex = parentIndex;
      parentIndex = parentIndex(currValueIndex);
    }
  }

  private int parentIndex(int index) {
    return (index - 1) / 2;
  }

  private void swap(int index1, int index2) {
    var temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }

  private boolean isFull() {
    return size == nums.length;
  }
}

