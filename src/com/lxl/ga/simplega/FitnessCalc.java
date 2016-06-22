package com.lxl.ga.simplega;

/**
 * 计算适应度
 *
 * @author lixiaolin
 * @createDate 2016-06-22 15:20
 */
public class FitnessCalc {

    private static byte[] solution = new byte[64];

    /**
     * 设置候选结果为一个 byte array
     *
     * @param newSolution 基因数组
     */
    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    /**
     * 将01字符串转换为01数组
     *
     * @param newSolution 基因字符串
     */
    public static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    /**
     * 通过和solution比较 ，计算个体的适应值
     * @param individual 待比较的个体
     * @return  返回适应度
     */
    public static int getFitness(Individual individual) {
        int fitness = 0;
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }

    //最优的适应值，即为基因序列的长度
    public static int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }
}