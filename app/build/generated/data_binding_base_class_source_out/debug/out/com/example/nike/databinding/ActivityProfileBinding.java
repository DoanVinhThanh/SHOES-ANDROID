// Generated by view binder compiler. Do not edit!
package com.example.nike.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.nike.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatButton editProfile;

  @NonNull
  public final LinearLayout main;

  @NonNull
  public final LinearLayout orderProfile;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final LinearLayout settingsProfile;

  @NonNull
  public final Toolbar toolbar;

  private ActivityProfileBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatButton editProfile, @NonNull LinearLayout main,
      @NonNull LinearLayout orderProfile, @NonNull CircleImageView profileImage,
      @NonNull LinearLayout settingsProfile, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.editProfile = editProfile;
    this.main = main;
    this.orderProfile = orderProfile;
    this.profileImage = profileImage;
    this.settingsProfile = settingsProfile;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.edit_profile;
      AppCompatButton editProfile = ViewBindings.findChildViewById(rootView, id);
      if (editProfile == null) {
        break missingId;
      }

      LinearLayout main = (LinearLayout) rootView;

      id = R.id.order_profile;
      LinearLayout orderProfile = ViewBindings.findChildViewById(rootView, id);
      if (orderProfile == null) {
        break missingId;
      }

      id = R.id.profile_image;
      CircleImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.settings_profile;
      LinearLayout settingsProfile = ViewBindings.findChildViewById(rootView, id);
      if (settingsProfile == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityProfileBinding((LinearLayout) rootView, editProfile, main, orderProfile,
          profileImage, settingsProfile, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
