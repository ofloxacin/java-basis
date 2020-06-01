package com.ofloxacin.algorithm.sort;

import com.ofloxacin.TimeSpanUtil;
import com.ofloxacin.util.PrintUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-29
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class SortTest {

    private int[] nums;

    private static int[] cache;

    private final static int COUNT = 10000;

    private final static Comparator<Integer> COMPARATOR = Comparator.comparingInt(o -> o);

    /**
     * 冒泡排序
     */
    @Test
    @DisplayName("Bubble Sort")
    public void bubbleSort() {
        Sort sort = new BubbleSort();
        sort.sort(nums);
    }

    /**
     * 选择排序
     */
    @Test
    @DisplayName("Selection Sort")
    public void selectionSort() {
        Sort sort = new SelectionSort();
        sort.sort(nums);
    }

    /**
     * 插入排序
     */
    @Test
    @DisplayName("Insertion Sort")
    public void insertionSort() {
        Sort sort = new InsertionSort();
        sort.sort(nums);
    }

    /**
     * 快速排序
     */
    @Test
    @DisplayName("Quick Sort")
    public void quickSort() {
        Sort sort = new QuickSort();
        sort.sort(nums);
    }

    /**
     * 归并
     */
    @Test
    @DisplayName("MergeSort")
    public void mergeSort() {
        Sort sort = new MergeSort();
        sort.sort(nums);
    }

    /**
     * 堆排序
     */
    @Test
    @DisplayName("HeapSort")
    public void heapSort() {
        Sort sort = new HeapSort();
        sort.sort(nums);
    }

    /**
     * 计数排序
     */
    @Test
    @DisplayName("Counting Sort")
    public void countingSort() {
        nums = new int[]{10, 3, 6, 12, 3, 15, 20, 5, 14, 13, 1, 3, 2, 5, 5, 3, 4};
        CountingSort countingSort = new CountingSort();
        countingSort.sort(nums, 100);
    }

    /**
     * 桶排序
     */
    @Disabled("TDB")
    @Test
    @DisplayName("Bucket Sort")
    public void bucketSort() {
        Sort sort = new BucketSort();
        sort.sort(nums);
    }

    /**
     * 基数排序
     */
    @Disabled("TDB")
    @Test
    @DisplayName("Radix Sort")
    public void radixSort() {
        Sort sort = new RadixSort();
        sort.sort(nums);
    }

    /**
     * 希尔排序
     */
    @Disabled("TDB")
    @Test
    @DisplayName("Shell Sort")
    public void shellSort() {
        Sort sort = new ShellSort();
        sort.sort(nums);
    }

    /**
     * 初始化待排序数据
     */
    @BeforeEach
    public void init() {
        if (cache == null) {
            Random random = new Random();
            cache = new int[COUNT];
            for (int i = 0; i < COUNT; i++) {
                cache[i] = random.nextInt();
            }
        }
        nums = Arrays.copyOf(cache, COUNT);
        TimeSpanUtil.init();
    }

    /**
     * 校验正确性
     *
     * @param testInfo
     */
    @AfterEach
    public void valid(TestInfo testInfo) {
        TimeSpanUtil.printSpan(testInfo.getDisplayName());
        PrintUtil.println(nums, 0, 10);
        for (int i = 0; i < nums.length - 1; i++) {
            if (COMPARATOR.compare(nums[i], nums[i + 1]) > 0) {
                System.out.println(nums[i]);
                System.out.println(nums[i + 1]);
                Assertions.fail();
            }
        }
    }
}
