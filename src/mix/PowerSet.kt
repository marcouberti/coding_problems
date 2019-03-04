package mix

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
class PowerSet {

    fun subsets(nums: IntArray): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        list.add(listOf()) //empty set
        for(n in nums) {
            val l: List<List<Int>> = list.map { it.toMutableList().apply { add(n) }.toList() }
            list.addAll(l)
        }
        return list
    }
}