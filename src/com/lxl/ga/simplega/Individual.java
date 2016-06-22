package com.lxl.ga.simplega;

/**
 * 个体
 *
 * @author lixiaolin
 * @createDate 2016-06-22 15:10
 */
public class Individual {

    static int defaultGeneLength = 64;
    //基因序列
    private byte[] genes = new byte[defaultGeneLength];
    // 个体的适应度
    private int fitness = 0;

    // 创建一个随机的 基因个体
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }

    public byte getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }

    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size(); i++) {
            sb.append(getGene(i));
        }
        return sb.toString();
    }
}