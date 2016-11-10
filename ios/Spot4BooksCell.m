//
//  Spot4BooksCell.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksCell.h"


@implementation Spot4BooksCell {
  UIView* rootView;
  UIImageView *coverImage;
}
- (id)initWithFrame:(CGRect)frame
{
  self = [super initWithFrame:frame];
  if (self) {
    
    
    rootView = [[UIView alloc] initWithFrame:CGRectZero];
    [rootView setBackgroundColor:[UIColor grayColor]];
    [rootView setTag:99];
    coverImage = [[UIImageView alloc] initWithFrame:CGRectZero];
    [coverImage setTag:100];
    [rootView addSubview:coverImage];
    [self.contentView addSubview:rootView];
    
    
  }
  
  return self;
  
}

-(void) setRealBounds:(CGSize) size withY:(float) y {
  [rootView setFrame:CGRectMake(0, y, size.width, size.height)];
  [coverImage setFrame:CGRectMake(0, 0, size.width, size.height)];
}

@end
