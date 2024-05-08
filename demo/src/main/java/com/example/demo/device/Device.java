package com.example.demo.device;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @SequenceGenerator(
            name = "device_sequence",
            sequenceName = "device_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_sequence"
    )
    private int id; 
    private int battery_power;
    private int blue;
    private float clock_speed;
    private int dual_sim;
    private float fc;
    private float four_g;
    private float int_memory;
    private float m_dep;
    private float mobile_wt;
    private float n_cores;
    private float pc;
    private float px_height;
    private float px_width;
    private float ram;
    private float sc_h;
    private float sc_w;
    private int talk_time;
    private int three_g;
    private int touch_screen;
    private int wifi;
    private int price_range;

    // empty constructor
    public Device() {
    }

    // create constructor with id
    public Device(int id, int battery_power, int blue, float clock_speed, int dual_sim, float fc, float four_g, float int_memory, float m_dep, float mobile_wt, float n_cores, float pc, float px_height, float px_width, float ram, float sc_h, float sc_w, int talk_time, int three_g, int touch_screen, int wifi, int price_range) {
        this.id = id;
        this.battery_power = battery_power;
        this.blue = blue;
        this.clock_speed = clock_speed;
        this.dual_sim = dual_sim;
        this.fc = fc;
        this.four_g = four_g;
        this.int_memory = int_memory;
        this.m_dep = m_dep;
        this.mobile_wt = mobile_wt;
        this.n_cores = n_cores;
        this.pc = pc;
        this.px_height = px_height;
        this.px_width = px_width;
        this.ram = ram;
        this.sc_h = sc_h;
        this.sc_w = sc_w;
        this.talk_time = talk_time;
        this.three_g = three_g;
        this.touch_screen = touch_screen;
        this.wifi = wifi;
        this.price_range = price_range;
    }
    // create constructor no id
    public Device(int battery_power, int blue, float clock_speed, int dual_sim, float fc, float four_g, float int_memory, float m_dep, float mobile_wt, float n_cores, float pc, float px_height, float px_width, float ram, float sc_h, float sc_w, int talk_time, int three_g, int touch_screen, int wifi, int price_range) {
        this.battery_power = battery_power;
        this.blue = blue;
        this.clock_speed = clock_speed;
        this.dual_sim = dual_sim;
        this.fc = fc;
        this.four_g = four_g;
        this.int_memory = int_memory;
        this.m_dep = m_dep;
        this.mobile_wt = mobile_wt;
        this.n_cores = n_cores;
        this.pc = pc;
        this.px_height = px_height;
        this.px_width = px_width;
        this.ram = ram;
        this.sc_h = sc_h;
        this.sc_w = sc_w;
        this.talk_time = talk_time;
        this.three_g = three_g;
        this.touch_screen = touch_screen;
        this.wifi = wifi;
        this.price_range = price_range;
    }

    // create getter and setter
    public int getBattery_power() {
        return battery_power;
    }

    public void setBattery_power(int battery_power) {
        this.battery_power = battery_power;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public float getClock_speed() {
        return clock_speed;
    }

    public void setClock_speed(float clock_speed) {
        this.clock_speed = clock_speed;
    }

    public int getDual_sim() {
        return dual_sim;
    }

    public int getPrice_range() {
        return price_range;
    }

    public void setPrice_range(int price_range) {
        this.price_range = price_range;
    }

}