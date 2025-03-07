package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Txt2ImgDTO {
    @JsonProperty("prompt")
    private String prompt = "";

    @JsonProperty("negative_prompt")
    private String negativePrompt = "";

    @JsonProperty("styles")
    @Valid
    private List<String> styles = null;

    @JsonProperty("seed")
    private Integer seed = -1;

    @JsonProperty("subseed")
    private Integer subseed = -1;

    @JsonProperty("subseed_strength")
    private Double subseedStrength = 0d;

    @JsonProperty("seed_resize_from_h")
    private Integer seedResizeFromH = -1;

    @JsonProperty("seed_resize_from_w")
    private Integer seedResizeFromW = -1;

    @JsonProperty("sampler_name")
    private String samplerName;

    @JsonProperty("batch_size")
    private Integer batchSize = 1;

    @JsonProperty("n_iter")
    private Integer nIter = 1;

    @JsonProperty("steps")
    private Integer steps = 50;

    @JsonProperty("cfg_scale")
    private Double cfgScale = 7d;

    @JsonProperty("width")
    private Integer width = 512;

    @JsonProperty("height")
    private Integer height = 512;

    @JsonProperty("restore_faces")
    private Boolean restoreFaces;

    @JsonProperty("tiling")
    private Boolean tiling;

    @JsonProperty("do_not_save_samples")
    private Boolean doNotSaveSamples = false;

    @JsonProperty("do_not_save_grid")
    private Boolean doNotSaveGrid = false;

    @JsonProperty("eta")
    private Double eta;

    @JsonProperty("denoising_strength")
    private Double denoisingStrength;

    @JsonProperty("s_min_uncond")
    private Double sMinUncond;

    @JsonProperty("s_churn")
    private Double sChurn;

    @JsonProperty("s_tmax")
    private Double sTmax;

    @JsonProperty("s_tmin")
    private Double sTmin;

    @JsonProperty("s_noise")
    private Double sNoise;

    @JsonProperty("override_settings")
    private Object overrideSettings;

    @JsonProperty("override_settings_restore_afterwards")
    private Boolean overrideSettingsRestoreAfterwards = true;

    @JsonProperty("refiner_checkpoint")
    private String refinerCheckpoint;

    @JsonProperty("refiner_switch_at")
    private Double refinerSwitchAt;

    @JsonProperty("disable_extra_networks")
    private Boolean disableExtraNetworks = false;

    @JsonProperty("firstpass_image")
    private String firstpassImage;

    @JsonProperty("comments")
    private Object comments;

    @JsonProperty("enable_hr")
    private Boolean enableHr = false;

    @JsonProperty("firstphase_width")
    private Integer firstphaseWidth = 0;

    @JsonProperty("firstphase_height")
    private Integer firstphaseHeight = 0;

    @JsonProperty("hr_scale")
    private Double hrScale = 2d;

    @JsonProperty("hr_upscaler")
    private String hrUpscaler;

    @JsonProperty("hr_second_pass_steps")
    private Integer hrSecondPassSteps = 0;

    @JsonProperty("hr_resize_x")
    private Integer hrResizeX = 0;

    @JsonProperty("hr_resize_y")
    private Integer hrResizeY = 0;

    @JsonProperty("hr_checkpoint_name")
    private String hrCheckpointName;

    @JsonProperty("hr_sampler_name")
    private String hrSamplerName;

    @JsonProperty("hr_prompt")
    private String hrPrompt = "";

    @JsonProperty("hr_negative_prompt")
    private String hrNegativePrompt = "";

    @JsonProperty("force_task_id")
    private String forceTaskId;

    @JsonProperty("sampler_index")
    private String samplerIndex = "Euler";

    @JsonProperty("script_name")
    private String scriptName;

    @JsonProperty("script_args")
    @Valid
    private List<String> scriptArgs = null;

    @JsonProperty("send_images")
    private Boolean sendImages = true;

    @JsonProperty("save_images")
    private Boolean saveImages = false;

    @JsonProperty("alwayson_scripts")
    private Object alwaysonScripts;

    @JsonProperty("infotext")
    private String infotext;
}
