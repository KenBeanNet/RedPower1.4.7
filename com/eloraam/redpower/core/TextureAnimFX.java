package com.eloraam.redpower.core;

import cpw.mods.fml.client.FMLTextureFX;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderEngine;
import org.lwjgl.opengl.GL11;

public class TextureAnimFX extends FMLTextureFX
{
    private String textureFile;
    private int tickRate;
    private int tick = 0;
    private int index = 0;
    public byte[][] textureFrames;

    private byte[] convertRGB(int[] var1)
    {
        byte[] var2 = new byte[var1.length * 4];

        for (int var3 = 0; var3 < var1.length; ++var3)
        {
            var2[var3 * 4] = (byte)(var1[var3] >> 16);
            var2[var3 * 4 + 1] = (byte)(var1[var3] >> 8);
            var2[var3 * 4 + 2] = (byte)var1[var3];
            var2[var3 * 4 + 3] = (byte)(var1[var3] >> 24);
        }

        return var2;
    }

    public TextureAnimFX(int var1, String var2, int var3, int[] var4)
    {
        super(var1);
        this.textureFile = var2;
        this.tickRate = var3;
        this.textureFrames = new byte[var4.length][];

        try
        {
            InputStream var5 = Minecraft.getMinecraft().texturePackList.getSelectedTexturePack().getResourceAsStream(var2);

            if (var5 == null)
            {
                throw new Exception("Image not found: " + var2);
            }

            BufferedImage var6 = ImageIO.read(var5);
            int[] var7 = new int[this.tileSizeBase * this.tileSizeBase];

            for (int var8 = 0; var8 < var4.length; ++var8)
            {
                int var9 = (var4[var8] & 15) * this.tileSizeBase;
                int var10 = (var4[var8] >> 4) * this.tileSizeBase;
                var6.getRGB(var9, var10, this.tileSizeBase, this.tileSizeBase, var7, 0, this.tileSizeBase);
                this.textureFrames[var8] = this.convertRGB(var7);
            }
        }
        catch (Exception var11)
        {
            var11.printStackTrace();
        }
    }

    public void onTick()
    {
        ++this.tick;

        if (this.tick >= this.tickRate)
        {
            this.tick = 0;
            ++this.index;

            if (this.index >= this.textureFrames.length)
            {
                this.index = 0;
            }

            this.imageData = this.textureFrames[this.index];
        }
    }

    public void bindImage(RenderEngine var1)
    {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, var1.getTexture(this.textureFile));
    }
}
